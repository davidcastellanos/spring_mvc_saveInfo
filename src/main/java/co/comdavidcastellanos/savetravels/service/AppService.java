package co.comdavidcastellanos.savetravels.service;

import co.comdavidcastellanos.savetravels.model.Expense;
import co.comdavidcastellanos.savetravels.repository.RepositoryExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Autowired
    private RepositoryExpense repositoryExpense;

    // Lista con todos los expenses registrados
    public List<Expense> traerTodosLosExpenses() {
        return repositoryExpense.findAll();
    }

    // Guardar o actualizar nuevo expense
    public Expense guardarExpense(Expense expense) {
        return repositoryExpense.save(expense);
    }

    // regresa un expense que tenga un ID específico o null si no existe
    public Expense buscarExpensePorId(Long id) {
        return repositoryExpense.findById(id).orElse(null);
    }

    // elimina un expense que tenga un ID específico
    public void eliminarExpense(long id) {
        repositoryExpense.deleteById(id);
    }


}
