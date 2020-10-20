package learn.calorietracker.data;

import learn.calorietracker.models.LogEntry;
import learn.calorietracker.models.LogEntryType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogEntryJdbcTemplateRepository implements LogEntryRepository{
    
    private final JdbcTemplate jdbcTemplate;
    
    private final RowMapper<LogEntry> mapper = (resultSet, i) -> {
        LogEntry logEntry = new LogEntry();
        logEntry.setId(resultSet.getInt("log_entry_id"));
        logEntry.setLoggedOn(resultSet.getString("logged_on"));
        logEntry.setType(resultSet.getInt("log_entry_type_id"));
        logEntry.setDescription(resultSet.getString("description"));
        logEntry.setCalories(resultSet.getInt("calories"));
        return logEntry;
    };

    public LogEntryJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<LogEntry> findAll() throws DataAccessException {
        final String sql = "select log_entry_id, logged_on, log_entry_type_id, description, calories from log_entry;";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<LogEntry> findByType(LogEntryType type) throws DataAccessException {
        return null;
    }

    @Override
    public LogEntry findById(int id) throws DataAccessException {
        return null;
    }

    @Override
    public LogEntry create(LogEntry entry) throws DataAccessException {
        return null;
    }
}
