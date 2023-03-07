package co.comdavidcastellanos.savetravels.controller;

import co.comdavidcastellanos.savetravels.model.Expense;
import co.comdavidcastellanos.savetravels.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class controllerExpensesAPI {
    @Autowired
    private AppService service;

    @GetMapping("/expenses/")
    public List<Expense> muestraExpenses() {
        return service.traerTodosLosExpenses();
    }

    @PostMapping("/expenses/")
    public Expense crearNuevoExpense(@RequestParam("expenseName") String expenseName,
                                     @RequestParam("vendor") String vendor,
                                     @RequestParam("amount") String amount,
                                     @RequestParam("description") String description) {

        Expense expense = new Expense(expenseName, vendor, amount, description);

        return service.guardarExpense(expense);
    }

    @GetMapping("/expenses/{id}/")
    public Expense obtenerExpensePorID(@PathVariable("id") Long id) {
        return service.buscarExpensePorId(id);
    }

    @DeleteMapping("/expenses/{id}/")
    public void eliminarExpensePorID(@PathVariable("id") long id) {
        service.eliminarExpense(id);
    }

    @PutMapping("/expenses/{id}/")
    public Expense actualizarUnExpense(@PathVariable("id") long id,
                                       @RequestParam("expenseName") String expenseName,
                                       @RequestParam("vendor") String vendor,
                                       @RequestParam("amount") String amount,
                                       @RequestParam("description") String description) {

        Expense newExpenseUpdated = new Expense(id, expenseName, vendor, amount, description);

        return service.guardarExpense(newExpenseUpdated);
    }



}
