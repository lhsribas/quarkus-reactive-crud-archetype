/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.domain.usecase;

import ${package}.domain.entity.EPayment;
import io.smallrye.mutiny.Uni;

public interface IUpdatePaymentUseCase {

    /**
     *
     * @param id
     * @param ePayment
     * @return
     */
    Uni<EPayment> update(final Long id, EPayment ePayment);
}
