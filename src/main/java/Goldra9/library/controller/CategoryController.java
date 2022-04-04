package Goldra9.library.controller;

import Goldra9.library.controller.form.CategoryForm;
import Goldra9.library.controller.form.MemberForm;
import Goldra9.library.domain.Category;
import Goldra9.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CategoryController
{
    private final CategoryRepository categoryRepository;

    //==회원가입 폼==//
    @GetMapping("/category/new")
    public String CreateForm(Model model)
    {
        model.addAttribute("CategoryForm", new CategoryForm());
        return "items/categoryForm";
    }

    //==카테고리 생성 폼==//
    @PostMapping("/category/new")
    public String createCategory(CategoryForm categoryForm)
    {
        Category category = new Category(categoryForm.getName());
        categoryRepository.save(category);
        return "redirect:/";
    }
}
