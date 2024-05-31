package com.in28minutes.learnspringframework.Test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService {
    @Qualifier("MySQL")
    public int[] retrieveData() {
        return new int[]{ 1, 2, 3, 4, 5};
    }
}
