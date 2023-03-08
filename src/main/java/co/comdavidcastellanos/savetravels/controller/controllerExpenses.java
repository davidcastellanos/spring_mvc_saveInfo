package co.comdavidcastellanos.savetravels.controller;

import co.comdavidcastellanos.savetravels.model.Expense;
import co.comdavidcastellanos.savetravels.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class controllerExpenses {

    @Autowired
    private AppService service;

    @GetMapping("/expenses")
    public String index(Model model, @ModelAttribute("formExpense") Expense expense) {
        List<Expense> listaExpenses = service.traerTodosLosExpenses();

        model.addAttribute("allExpenses", listaExpenses);

        return "index.jsp";
    }

    @PostMapping("/expenses")
    public String crearNuevoExpenseJSP(@Valid @ModelAttribute("formExpense") Expense expense,
                                       BindingResult result) {

        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            service.guardarExpense(expense);
            return "redirect:/expenses";
        }

    }


    @GetMapping("/expenses/{id}")
    public String obtenerExpensePorIDJSP(Model model, @PathVariable("id") Long id) {

        Expense expense = service.buscarExpensePorId(id);
        model.addAttribute("expense", expense);
        return "expenseDetail.jsp";
    }

    @GetMapping("/edit/{id}")
    public String expenseAEditarPorIDJSP(Model model, @PathVariable("id") Long id,
                                        @ModelAttribute("formExpense") Expense expense) {
        Expense expenseAEditar = service.buscarExpensePorId(id);

        if (expenseAEditar == null) {
            return "redirect:/expenses";
        }

        model.addAttribute("expenseAEditar", expenseAEditar);

        return "editExpense.jsp";

    }

    @PutMapping("/edit/{id}")
    public String actualizarUnExpensePorIDJSP(@Valid @ModelAttribute("expenseAEditar") Expense expense,
                                               BindingResult result) {
        if (result.hasErrors()) {
            return "editExpense.jsp";
        } else {
            service.guardarExpense(expense);
            return "redirect:/expenses";
        }

    }


    @DeleteMapping("/delete/{id}")
    public String eliminarExpensePorIDJSP(@PathVariable("id") long id) {
        service.eliminarExpense(id);
        return "redirect:/expenses";
    }



}
