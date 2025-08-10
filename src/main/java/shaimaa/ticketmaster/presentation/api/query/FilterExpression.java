package shaimaa.ticketmaster.presentation.api.query;

import lombok.Data;

import java.util.List;

@Data
public class FilterExpression extends FilterExpressionArg {
    String simpleValue;

    String operator;

    List<FilterExpression> args;

    public FilterExpression(String simpleVlaue) {
        this.simpleValue = simpleVlaue;
    }

    public FilterExpression(String operator, List<FilterExpression> args) {
        this.operator = operator;
        this.args = args;
    }
}
