package learn.calorietracker.data;

import learn.calorietracker.App;
import learn.calorietracker.models.LogEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogEntryJdbcTemplateRepositoryTest {

    LogEntryJdbcTemplateRepository repository;

    public LogEntryJdbcTemplateRepositoryTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        repository = context.getBean(LogEntryJdbcTemplateRepository.class);
    }

    @BeforeAll
    static void oneTimeSetup() {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        jdbcTemplate.update("call set_known_good_state();");
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<LogEntry> all = repository.findAll();
        assertNotNull(all);
    }
}