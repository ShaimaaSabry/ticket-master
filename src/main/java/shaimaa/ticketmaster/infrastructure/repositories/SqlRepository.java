package shaimaa.ticketmaster.infrastructure.repositories;

import shaimaa.ticketmaster.presentation.api.query.FilterExpression;

import java.util.ArrayList;
import java.util.List;

public class SqlRepository {
    protected String transformFilterExpression(FilterExpression filterExpression) {
        List<String> transformedArgs = new ArrayList<>();
        for (FilterExpression arg : filterExpression.getArgs()) {
            if (arg.getSimpleValue() != null) {
                transformedArgs.add(arg.getSimpleValue());
            } else {
                transformedArgs.add(this.transformFilterExpression(arg));
            }
        }

        return this.transformOperatorToSql(
                filterExpression.getOperator().toUpperCase(),
                transformedArgs
        );
    }

    private String transformOperatorToSql(String operator, List<String> args) {
        operator = operator.toUpperCase();
        switch (operator) {
            case "LIKE":
                return args.get(0) + " like " + args.get(1);

            case "EQ":
                return args.get(0) + " = " + args.get(1);

            case "AND":
                return String.join(" AND ", args);
        }

        throw new RuntimeException("Unknown operator");
    }
}
