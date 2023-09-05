package optional;

import java.util.Optional;

class ContInfo1 {
    Optional<String> phone;   // null 일 수 있음
    Optional<String> adrs;    // null 일 수 있음

    public ContInfo1(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }
    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }
}

class FlatMapElseOptional {
    public static void main(String[] args) {
        Optional<ContInfo1> ci = Optional.of(
            new ContInfo1(Optional.ofNullable(null), Optional.of("Republic of Korea"))
        );
        
        String phone = ci.flatMap(ContInfo1::getPhone).orElse("Empty");
        	//Optional1<ContInfo1>이 반환형인데 Optional<String>을 리턴
        String addr = ci.flatMap(ContInfo1::getAdrs).orElse("Empty");;
          
        System.out.println(phone);
        System.out.println(addr);
    }
}