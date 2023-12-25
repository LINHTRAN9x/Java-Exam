package movieTickets.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowTime {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int showtimeId;  // Thêm trường showtimeId

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public ShowTime(int showtimeId,LocalDateTime startTime, LocalDateTime endTime) {
        this.showtimeId = showtimeId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

}
