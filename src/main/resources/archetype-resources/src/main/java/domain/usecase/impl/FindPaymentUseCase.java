/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.domain.usecase.impl;

import ${package}.domain.entity.EPayment;
import ${package}.domain.gateway.IPaymentGateway;
import ${package}.domain.usecase.IFindPaymentUseCase;
import ${package}.infra.dataprovider.PaymentDataProvider;
import io.smallrye.mutiny.Uni;

import java.util.List;

public final class FindPaymentUseCase implements IFindPaymentUseCase {

    private IPaymentGateway gateway;

    public FindPaymentUseCase(){
        gateway = new PaymentDataProvider();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<EPayment> getById(final Long id) {
        return gateway.getById(id);
    }

    /**
     *
     * @return
     */
    @Override
    public Uni<List<EPayment>> getAll() {
        return gateway.getAll();
    }
}
