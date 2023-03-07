package co.comdavidcastellanos.savetravels.repository;

import co.comdavidcastellanos.savetravels.model.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryExpense extends CrudRepository<Expense, Long> {

    // SELECT * FROM expenses
    List<Expense> findAll();

    // SELECT * FROM expenses WHERE expenseName =  '<expenseName>';
    List<Expense> findByExpenseName(String expenseName);

    // SELECT * FROM expenses WHERE vendor =  '<vendor>';
    List<Expense> findByVendor(String vendor);

    // SELECT * FROM expenses WHERE id =  '<id>';
    List<Expense> findById(long id);

    // INSERT - UPDATE
    Expense save(Expense expense);


    // DELETE * FROM expenses WHERE id =  '<id>';
    void deleteById(long id);


}
