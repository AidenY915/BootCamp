package optional;

import java.util.Optional;

class Friend2 {
    Optional<String> name;
    Optional<Company2> cmp;    // null 일 수 있음

    public Friend2(Optional<String> n, Optional<Company2> c) {
        name = n;
        cmp = c;
    }

    public Optional<String> getName() { return name; }
    public Optional<Company2> getCmp() { return cmp; }
}

class Company2 {
	Optional<String> cName;
	Optional<ContInfo2> cInfo;    // null 일 수 있음

    public Company2(Optional<String> cn, Optional<ContInfo2> ci) {
        cName = cn;
        cInfo = ci;
    }

    public Optional<String> getCName() { return cName; }
    public Optional<ContInfo2> getCInfo() { return cInfo; }

}

class ContInfo2 {
	Optional<String> phone;   // null 일 수 있음
	Optional<String> adrs;    // null 일 수 있음

    public ContInfo2(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }

    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }

}

class NullPointerCaseStudy2 {
    public static void showCompAddr(Friend2 f) {
       String addr = f.getCmp().flatMap(Company2::getCInfo).flatMap(ContInfo2::getAdrs).orElse("There's no address information.");
       System.out.println(addr);
    }

    public static void main(String[] args) {

        ContInfo2 ci = new ContInfo2(Optional.of("321-444-577"), Optional.of("Republic of Korea"));
        Company2 cp = new Company2(Optional.of("YaHo Co., Ltd."), Optional.of(ci));
        Friend2 frn = new Friend2(Optional.of("LEE SU"), Optional.of(cp));

        // 친구 정보에서 회사 주소를 출력
        showCompAddr(frn);
    }
}
