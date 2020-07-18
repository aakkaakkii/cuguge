package ge.cugu.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PaginatedListWrapper<T> {
    private long start;
    private long limit;
    private long total;
    private List<T> list;
}
