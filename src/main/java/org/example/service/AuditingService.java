package org.example.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class AuditingService {
    private static long _20230401 = 1680296400000L;
    private static long _20230831 = 1693429200000L;

    public Date between() {
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(_20230401, _20230831);

        return new Date(randomMillisSinceEpoch);
    }

    public Date between(Date startInclusive) {
        long startMillis = startInclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, _20230831);

        return new Date(randomMillisSinceEpoch);
    }
}
