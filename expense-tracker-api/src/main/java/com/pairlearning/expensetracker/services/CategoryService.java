package com.pairlearning.expensetracker.services;

import com.pairlearning.expensetracker.domain.Category;
import com.pairlearning.expensetracker.exception.EtBadRequestException;
import com.pairlearning.expensetracker.exception.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {
 List<Category> fetchAllCategories(Integer userId);
 Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
 Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;
 void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
 void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

}