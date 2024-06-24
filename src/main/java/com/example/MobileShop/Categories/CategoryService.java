package com.example.MobileShop.Categories;

import com.example.MobileShop.Categories.Resquest.RequestCategoryChangeName;
import com.example.MobileShop.Categories.Resquest.RequestSetParentCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categories createCategory(CategoryDto categoryDto){
        Categories category = modelMapper.map(categoryDto,Categories.class);
        return categoriesRepository.save(category);
    }

    public List<Categories> getAllCategory(){
        return categoriesRepository.findAll();
    }

    public Categories updateNameCategory(UUID categoryId, RequestCategoryChangeName newName){
        Categories categories =  categoriesRepository.findById(categoryId).orElseThrow();
        categories.setName(newName.getName());
        categoriesRepository.save(categories);
        return categories;
    }


    public Categories setNullParentCategoryById(UUID categoryId){
        Categories category = categoriesRepository.findById(categoryId).orElseThrow();
        category.setParent_id(null);
        categoriesRepository.save(category);
        return category;
    }

    public List<Categories> getAllChildrenByParentId(UUID categoryId){
        List<Categories> categories = categoriesRepository.findCategoryByParentId(categoryId);
        return categories;
    }


    public List<Categories> getAllCategoryParent(){
        List<Categories> categories = categoriesRepository.getAllCategoryParent();
        return categories;
    }

    public Categories setParentForCategory(UUID id, RequestSetParentCategory categoryParent){
        Categories categories = categoriesRepository.findById(id).orElseThrow();
        categories.setParent_id(categoryParent.getCategoryParent());
        categoriesRepository.save(categories);
        return categories;
    }

    public boolean deleteCategory(UUID categoryId){
        Categories category =  categoriesRepository.findById(categoryId).orElseThrow();
        if(category.getParent_id() == null){
            List<Categories> categoryChildrens = getAllChildrenByParentId(category.getCategoryId());
            for(Categories categoryChildren : categoryChildrens){
                setNullParentCategoryById(categoryChildren.getCategoryId());
            }
            categoriesRepository.delete(category);
            return true;
        }
        categoriesRepository.delete(category);
        return true;
    }
}
