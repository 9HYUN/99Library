package Goldra9.bookStore.domain;



import lombok.Getter;
import lombok.NoArgsConstructor;
import Goldra9.bookStore.domain.Address;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private String phone;

    private String email;

    private String personNumber;

    @OneToMany(mappedBy = "member")
    private List<Rental> rentalList = new ArrayList<>();

    public Member(String name, Address address, String phone, String email, String personNumber)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.personNumber = personNumber;
    }

}
