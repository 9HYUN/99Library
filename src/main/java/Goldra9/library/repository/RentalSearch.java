package Goldra9.library.repository;

import Goldra9.library.domain.RentalStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RentalSearch
{
    private String memberName;
    private RentalStatus rentalStatus;
}
