package org.littlahands.dddsample.dddsample.v1.application_service;

import org.littlahands.dddsample.dddsample.v1.domain.ScreeningV1;
import org.littlahands.dddsample.dddsample.v1.domain.dao.ScreeningDao;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ScreeningImMemoryDao implements ScreeningDao {
    private Map<String, ScreeningV1> data = new HashMap<>();

    @Override
    public Optional<ScreeningV1> findScreeningById(String screeningId) {
        return Optional.ofNullable(data.get(screeningId));
    }

    @Override
    public void insert(ScreeningV1 screening) {
        data.put(screening.getScreeningId(), screening);
    }

    @Override
    public Optional<ScreeningV1> findScreeningByEmailAddress(String emailAddress) {
        return data.entrySet().stream()
            .filter(e -> e.getValue().getApplicantEmailAddress().equals(emailAddress))
            .map(Map.Entry::getValue)
            .findAny();
    }
}