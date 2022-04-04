package Goldra9.library.controller;


import Goldra9.library.domain.Category;
import Goldra9.library.domain.Member;
import Goldra9.library.domain.Rental;
import Goldra9.library.domain.item.Item;
import Goldra9.library.repository.CategoryRepository;
import Goldra9.library.repository.RentalRepository;
import Goldra9.library.repository.RentalSearch;
import Goldra9.library.service.ItemService;
import Goldra9.library.service.MemberService;
import Goldra9.library.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;
    private final MemberService memberService;
    private final ItemService itemService;
    private final RentalRepository rentalRepository;
    private final CategoryRepository categoryRepository;

    //==대여 폼==//
    @GetMapping("/rental")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findAllItem();
        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "rental/rentalForm";
    }

    //==대여 등록==//
    @PostMapping("/rental")
    public String rental(@RequestParam("memberId") Long memberId,
                         @RequestParam("itemId") Long itemId,
                         @RequestParam("count") int count) {
        rentalService.Rental(memberId, itemId, count);
        return "redirect:/";
    }

    //==대여 리스트==//
    @GetMapping("/rentals")
    public String rentalList(@ModelAttribute("rentalSearch") RentalSearch rentalSearch, Model model, Rental rental) {
        List<Rental> rentals = rentalService.findRental(rentalSearch);
        model.addAttribute("rentals", rentals);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        
        return "rental/rentalList";
    }

    //==대여 취소==//
    @PostMapping("/rentals/{rentalId}/cancel")
    public String cancelRental(@PathVariable("rentalId") Long rentalId)
    {
        rentalService.cancel(rentalId);
        return "redirect:/rentals";
    }
}
