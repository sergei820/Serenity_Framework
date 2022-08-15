package utils;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ContextKeeper {
    INSTANCE;

    @Setter
    private Integer testCaseId;
}
