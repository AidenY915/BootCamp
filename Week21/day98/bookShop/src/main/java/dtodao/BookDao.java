package dtodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDao {
	private DataSource ds;
	private static final String CONNECTION_POOL = "jdbc/bookshop";
	private static final String TABLE = "book";

	private BookDao() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/" + CONNECTION_POOL);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static BookDao dao = new BookDao();

	public static BookDao getBookDao() {
		return dao;
	}

	public List<BookDto> selectBooks() {
		List<BookDto> books = new ArrayList<BookDto>();
		String selectBooksQuery = "SELECT * FROM " + TABLE;
		try (Connection conn = ds.getConnection();
				PreparedStatement selectBooksStmt = conn.prepareStatement(selectBooksQuery);
				ResultSet rs = selectBooksStmt.executeQuery()) {
			while (rs.next()) {
				BookDto book = new BookDto();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("price"));
				books.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public BookDto selectBook(int id) {
		String selectBookQuery = "SELECT * FROM " + TABLE + " WHERE id = '" + id + "'";
		BookDto book = null;
		try (Connection conn = ds.getConnection();
				PreparedStatement selectBookStmt = conn.prepareStatement(selectBookQuery);
				ResultSet rs = selectBookStmt.executeQuery()) {
			if (rs.next()) {
				book = new BookDto();
				book.setId(id);
				book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
}
