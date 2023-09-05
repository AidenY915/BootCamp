package optional;

import java.util.Optional;

class ContInfo {
    String phone;   // null 일 수 있음
    String adrs;    // null 일 수 있음

    public ContInfo(String ph, String ad) {
        phone = ph;
        adrs = ad;
    }

    public String getPhone() { return phone; }
    public String getAdrs() { return adrs; }

}

class IfElseOptional {
    public static void main(String[] args) {
        ContInfo ci = new ContInfo(null, "Republic of Korea");
        
        String phone;
        String addr;
       
        
        Optional<ContInfo> opt = Optional.of(ci);
        phone = opt.map(ContInfo::getPhone).orElse("There is no phone number.");
        addr = opt.map(ContInfo::getAdrs).orElse("There is no address.");
        // 맵을 써야 다시 Optional로 포장됨.
        			
        System.out.println(phone);
        System.out.println(addr);
    }
}