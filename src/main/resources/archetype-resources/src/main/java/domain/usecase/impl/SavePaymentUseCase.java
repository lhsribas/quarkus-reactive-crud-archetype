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
import ${package}.domain.usecase.ISavePaymentUseCase;
import ${package}.infra.dataprovider.PaymentDataProvider;
import io.smallrye.mutiny.Uni;

public final class SavePaymentUseCase implements ISavePaymentUseCase {

    private IPaymentGateway gateway;

    public SavePaymentUseCase(){
        gateway = new PaymentDataProvider();
    }

    /**
     *
     * @param ePayment
     * @return
     */
    @Override
    public Uni<EPayment> save(EPayment ePayment) {
        return gateway.save(of(ePayment));
    }

    /**
     *
     * @param ePayment
     * @return
     */
    private EPayment of(EPayment ePayment){
        // Instantiate ZonedDateTime with Brazil GMT
        ePayment.setCreatedAt(ZonedDateFactory.now(ZonedDateFactory.BR));
        return ePayment;
    }
}
