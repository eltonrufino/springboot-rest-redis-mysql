package  com.elton.app.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elton.app.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	Page<Expense> findByUserCodeAndExpenseDateBefore(Long idUser, LocalDateTime expenseDate, Pageable pageable);

	Page<Expense> findByUserCodeAndExpenseDateBetween(Long idUser, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}