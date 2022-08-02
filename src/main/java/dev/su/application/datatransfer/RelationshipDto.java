package dev.su.application.datatransfer;

import lombok.Value;

import java.util.List;

@Value
public class RelationshipDto {
    String name;
    String rootObject;
    List<RelationshipJoinDto> joins;

    @Value
    public static class RelationshipJoinDto {
        String name;
        String cardinality;
        String joinType;
        JoinConditionDto joinCondition;
    }

    @Value
    public static class JoinConditionDto {
        String rootObjectName;
        String rootObjectField;
        String rootObjectAlias;

        String joinObjectName;
        String joinObjectField;
        String joinObjectAlias;

        String operator;
    }

}
