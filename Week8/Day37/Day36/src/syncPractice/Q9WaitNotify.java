package syncPractice;

class NewsPaper {
	String news;

	public String getNews() {
		if(news == null) {
			synchronized(this) {
				try {
					wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return news;
	}
	public void setNews(String news) {
		this.news = news;
		synchronized(this) {
			notify();
		}
	}
}

class ReaderThread extends Thread{
	NewsPaper newsPaper;
	@Override
	public void run() {
		System.out.println(newsPaper.getNews()); 
	}
	public void setNewsPaper(NewsPaper newsPaper) {
		this.newsPaper = newsPaper;
	}
}

class WriterThread extends Thread{
	NewsPaper newsPaper;
	@Override
	public void run() {
		newsPaper.setNews("기사 내용"); 
	}
	public void setNewsPaper(NewsPaper newsPaper) {
		this.newsPaper = newsPaper;
	}
}

public class Q9WaitNotify {

	public static void main(String[] args) {
		NewsPaper newsPaper = new NewsPaper();
		WriterThread writerThread = new WriterThread();
		ReaderThread readerThread = new ReaderThread();

		readerThread.setNewsPaper(newsPaper);
		writerThread.setNewsPaper(newsPaper);

		readerThread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		writerThread.start();
	}

}
