/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.domain.usecase;

import ${package}.domain.entity.EPayment;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface IFindPaymentUseCase {

    /**
     *
     * @param id
     * @return
     */
    Uni<EPayment> getById(final Long id);

    /**
     *
     * @return
     */
    Uni<List<EPayment>> getAll();
}
