package shaimaa.ticketmaster.presentation.api.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Query {
    private FilterExpression filterExpression;

    public void addFilterExpression() {
        FilterExpression args0 = new FilterExpression("name");
        FilterExpression args1 = new FilterExpression("'%Amr%'");
        List<FilterExpression> args = new ArrayList<>(Arrays.asList(args0, args1));
        FilterExpression exp1 = new FilterExpression("like", args);

        args0 = new FilterExpression("city_id");
        args1 = new FilterExpression("'1'");
        args = new ArrayList<>(Arrays.asList(args0, args1));
        FilterExpression exp2 = new FilterExpression("eq", args);

        args = new ArrayList<>(Arrays.asList(exp1, exp2));
        FilterExpression exp3 = new FilterExpression("and", args);

        this.filterExpression = exp3;
    }
}
