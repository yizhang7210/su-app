package dev.su.application.datatransfer;

import dev.su.domain.datasource.*;

import java.util.stream.Collectors;

public class RelationshipTransformer {

    public Relationship fromDto(RelationshipDto relationshipDto) {
        return Relationship.of(
                RelationshipName.of(relationshipDto.getName()),
                SourceObjectName.of(relationshipDto.getRootObject()),
                relationshipDto.getJoins().stream()
                        .map(join -> RelationshipJoin.of(
                                join.getName(),
                                RelationshipJoinCondition.of(
                                        SourceObjectName.of(join.getJoinCondition().getRootObjectName()),
                                        SourceObjectFieldName.of(join.getJoinCondition().getRootObjectField()),
                                        SourceObjectName.of(join.getJoinCondition().getRootObjectAlias()),
                                        SourceObjectName.of(join.getJoinCondition().getJoinObjectName()),
                                        SourceObjectFieldName.of(join.getJoinCondition().getJoinObjectField()),
                                        SourceObjectName.of(join.getJoinCondition().getJoinObjectAlias()),
                                        RelationshipJoinCondition.JoinOperator.valueOf(join.getJoinCondition().getOperator())
                                ),
                                RelationshipJoin.Cardinality.valueOf(join.getCardinality()),
                                RelationshipJoin.JoinType.valueOf(join.getJoinType())
                        ))
                        .collect(Collectors.toList())
        );
    }

    public RelationshipDto toDto(Relationship relationship) {
        return new RelationshipDto(
                relationship.getName().getValue(),
                relationship.getRootObject().getValue(),
                relationship.getJoins().stream()
                        .map(join -> new RelationshipDto.RelationshipJoinDto(
                                join.getName(),
                                join.getCardinality().name(),
                                join.getJoinType().name(),
                                new RelationshipDto.JoinConditionDto(
                                        join.getJoinCondition().getRootObjectName().getValue(),
                                        join.getJoinCondition().getRootObjectField().getValue(),
                                        join.getJoinCondition().getRootObjectAlias().getValue(),
                                        join.getJoinCondition().getJoinObjectName().getValue(),
                                        join.getJoinCondition().getJoinObjectField().getValue(),
                                        join.getJoinCondition().getJoinObjectAlias().getValue(),
                                        join.getJoinCondition().getOperator().name()
                                )
                        ))
                        .collect(Collectors.toList())
        );

    }

}
