package Goldra9.bookStore.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

//== 회원 Form ==//
@Getter @Setter
public class MemberForm
{
    @NotEmpty
    private String name;
    private String city;
    private String street;
    private String zipcode;
    private String phone;
    private String email;
    private String personNumber;
}
