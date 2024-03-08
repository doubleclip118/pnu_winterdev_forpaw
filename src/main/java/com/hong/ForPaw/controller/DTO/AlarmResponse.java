package com.hong.ForPaw.controller.DTO;

import java.util.List;

public class AlarmResponse {

    public record FindAlarmsDTO(List<AlarmDTO> alarms) {}

    public record AlarmDTO(Long id, String content, boolean isRead) {}
}