/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.domain.usecase.impl;

import ${package}.cross.ZonedDateFactory;
import ${package}.domain.entity.EPayment;
import ${package}.domain.gateway.IPaymentGateway;
import ${package}.domain.usecase.IUpdatePaymentUseCase;
import ${package}.infra.dataprovider.PaymentDataProvider;
import io.smallrye.mutiny.Uni;

public final class UpdatePaymentUseCase implements IUpdatePaymentUseCase {

    private IPaymentGateway gateway;

    public UpdatePaymentUseCase(){
        gateway = new PaymentDataProvider();
    }

    /**
     *
     * @param id
     * @param ePayment
     * @return
     */
    @Override
    public Uni<EPayment> update(Long id, EPayment ePayment) {
        return gateway.update(id, of(ePayment));
    }

    /**
     *
     * @param ePayment
     * @return
     */
    private EPayment of(EPayment ePayment){
        // Instantiate ZonedDateTime with Brazil GMT
        ePayment.setUpdatedAt(ZonedDateFactory.now(ZonedDateFactory.BR));
        return ePayment;
    }
}
