/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.domain.usecase;

import io.smallrye.mutiny.Uni;

public interface IDeletePaymentUseCase {

    /**
     *
     * @param id
     * @return
     */
    Uni<Boolean> delete(final Long id);
}
