package com.programminghavare.springbootmongodbtutorial.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.programminghavare.springbootmongodbtutorial.model.Expense;
import com.programminghavare.springbootmongodbtutorial.model.ExpenseCategory;
import com.programminghavare.springbootmongodbtutorial.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDatabase", author = "Oktay")
    public void seedDatabase(ExpenseRepository expenseRepository) {

        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("Movie Tickets", ExpenseCategory.ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Dinner", ExpenseCategory.RESTAURANT, BigDecimal.valueOf(60)));
        expenseList.add(createNewExpense("Netflix", ExpenseCategory.ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Gym", ExpenseCategory.MISC, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Internet", ExpenseCategory.UTILITIES, BigDecimal.valueOf(30)));

        expenseRepository.insert(expenseList);
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal amount) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseAmount(amount);
        expense.setExpenseCategory(expenseCategory);
        return expense;
    }
}


