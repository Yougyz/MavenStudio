package org.neo4j.studio.controller;


import org.neo4j.studio.domain.TypeOf;
import org.neo4j.studio.service.CategoryService;
import org.neo4j.studio.domain.*;
import org.neo4j.studio.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.jws.WebParam.Mode;


@Controller
public class CategoryController {
	
	@Autowired protected CategoryRepository categoryRepository;
	
	@Autowired protected TypeRepository typeRepository;

	@Autowired
	private CategoryService categoryService;

    // Initialisation du formulaire avec la liste des types de personne
    @RequestMapping(value = "/initCreateCategoryPersonneForm", method = RequestMethod.GET, headers = "Accept=text/html")
    public String initListTypeOfPersonne(Model model ) {
            List<TypeOf> listTypeOf = typeRepository.findTypeOfPersonne();
            model.addAttribute("listTypeOf", listTypeOf);
            model.addAttribute("nameCategoryCreate", "Personne");
        return "category/createForm";
    }     
    // Initialisation du formulaire avec la liste des types de structure
    @RequestMapping(value = "/initCreateCategoryStructureForm", method = RequestMethod.GET, headers = "Accept=text/html")
    public String initListTypeOfStructure(Model model ) {
            List<TypeOf> listTypeOf = typeRepository.findTypeOfStructure();
            model.addAttribute("listTypeOf", listTypeOf);
            model.addAttribute("nameCategoryCreate", "Structure");
        return "category/createForm";
    }    
    //Creation de la catégorie
    @RequestMapping(value = "/createCategory", method = RequestMethod.POST, headers = "Accept=text/html")
    public String createCategory(Model model, @RequestParam(value = "nameCat",required = false) String nameCat, @RequestParam(value = "nameType",required = false) String nametype) {
    	Category category =   categoryService.addCategoryTyped(nameCat, nametype);
    	model.addAttribute("category", category);
        return "category/resultCreateCategory";
    }

    
}
