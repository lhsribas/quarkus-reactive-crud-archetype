/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.domain.usecase.impl;

import ${package}.domain.gateway.IPaymentGateway;
import ${package}.domain.usecase.IDeletePaymentUseCase;
import ${package}.infra.dataprovider.PaymentDataProvider;
import io.smallrye.mutiny.Uni;

public final class DeletePaymentUseCase implements IDeletePaymentUseCase {

    private IPaymentGateway gateway;

    public DeletePaymentUseCase(){
        gateway = new PaymentDataProvider();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<Boolean> delete(final Long id) {
        return gateway.delete(id);
    }
}
