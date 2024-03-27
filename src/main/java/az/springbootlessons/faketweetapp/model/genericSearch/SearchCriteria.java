package az.springbootlessons.faketweetapp.model.genericSearch;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchCriteria {
    String key;
    Object value;
    SearchOperation operation;
}
