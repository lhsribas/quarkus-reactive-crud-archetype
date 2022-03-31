/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.app.service;

import ${package}.app.dto.PaymentRequest;
import ${package}.app.dto.PaymentResponse;
import ${package}.domain.entity.EPayment;
import ${package}.domain.usecase.IDeletePaymentUseCase;
import ${package}.domain.usecase.IFindPaymentUseCase;
import ${package}.domain.usecase.ISavePaymentUseCase;
import ${package}.domain.usecase.IUpdatePaymentUseCase;
import ${package}.domain.usecase.impl.DeletePaymentUseCase;
import ${package}.domain.usecase.impl.FindPaymentUseCase;
import ${package}.domain.usecase.impl.SavePaymentUseCase;
import ${package}.domain.usecase.impl.UpdatePaymentUseCase;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public final class PaymentServiceFacade implements PaymentService {

    private ISavePaymentUseCase savePaymentUseCase;
    private IUpdatePaymentUseCase updatePaymentUseCase;
    private IDeletePaymentUseCase deletePaymentUseCase;
    private IFindPaymentUseCase findPaymentUseCase;

    public PaymentServiceFacade(){
        this.savePaymentUseCase = new SavePaymentUseCase();
        this.updatePaymentUseCase = new UpdatePaymentUseCase();
        this.deletePaymentUseCase = new DeletePaymentUseCase();
        this.findPaymentUseCase = new FindPaymentUseCase();
    }

    /**
     *
     * @param request
     * @return
     */
    @Override
    public Uni<PaymentResponse> save(PaymentRequest request) {
        return savePaymentUseCase.save(Mapper.requestToEPayment(request))
                .onItem()
                    .ifNotNull()
                        .transform(entity -> { return Mapper.ePaymentToResponse(entity);});
    }

    /**
     *
     * @param id
     * @param request
     * @return
     */
    @Override
    public Uni<PaymentResponse> update(Long id, PaymentRequest request) {
        return updatePaymentUseCase.update(id, Mapper.requestToEPayment(request))
                .onItem()
                    .ifNotNull()
                        .transform(entity -> { return Mapper.ePaymentToResponse(entity); });
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<Boolean> delete(Long id) {
        return deletePaymentUseCase.delete(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<PaymentResponse> getById(Long id) {
        return findPaymentUseCase.getById(id)
                .onItem()
                    .ifNotNull()
                        .transform(entity -> { return Mapper.ePaymentToResponse(entity);});
    }

    /**
     *
     * @return
     */
    @Override
    public Uni<List<PaymentResponse>> getAll() {
        return null;
    }

    /**
     *
     */
    static class Mapper {

        /**
         *
         * @param request
         * @return
         */
       public static EPayment requestToEPayment(final PaymentRequest request){
            Objects.nonNull(request);

            var e = new EPayment();
            e.setCustomer(request.getCustomer());
            e.setProductItem(request.productItem);
            e.setTotalCost(request.getTotalCost());

            return e;
        }

        /**
         *
         * @param ePayment
         * @return
         */
        public static PaymentResponse ePaymentToResponse(final EPayment ePayment){
            Objects.nonNull(ePayment);

            var response = new PaymentResponse();
            response.setCreatedAt(ePayment.getCreatedAt());
            response.setUpdatedAt(ePayment.getUpdatedAt());
            response.setId(ePayment.getId());
            response.setCustomer(ePayment.getCustomer());
            response.setProductItem(ePayment.getProductItem());
            response.setTotalCost(ePayment.getTotalCost());

            return response;
        }

        /**
         *
         * @param ePayments
         * @return
         */
        public static List<PaymentResponse> ePaymentToResponse(final List<EPayment> ePayments){
            Objects.nonNull(ePayments);

            return ePayments.stream()
                    .map(entity -> ePaymentToResponse(entity))
                    .collect(Collectors.toList());
        }

    }

}
