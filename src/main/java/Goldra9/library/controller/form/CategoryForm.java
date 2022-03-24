package Goldra9.library.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryForm
{
    //==카테고리 form==//
    private Long id;
    private String name;

    public void createCategory(String name)
    {
        this.name = name;
    }
}
