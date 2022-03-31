/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.infra.dataprovider;

import ${package}.domain.entity.EPayment;
import ${package}.domain.gateway.IPaymentGateway;
import ${package}.infra.db.model.Payment;
import ${package}.infra.db.repository.IPaymentRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public final class PaymentDataProvider  implements IPaymentGateway {

    @Inject
    private IPaymentRepository repository;

    /**
     *
     * @param ePayment
     * @return
     */
    @Override
    public Uni<EPayment> save(EPayment ePayment) {
        return repository.save(Mapper.ePaymentToPayment(ePayment))
                .onItem()
                    .ifNotNull()
                        .transform(jpa -> { return Mapper.paymentToePayment(jpa); });
    }

    /**
     *
     * @param id
     * @param ePayment
     * @return
     */
    @Override
    public Uni<EPayment> update(final Long id, final EPayment ePayment) {
        return repository.update(id, Mapper.ePaymentToPayment(ePayment))
                .onItem()
                    .ifNotNull()
                        .transform(jpa -> {return Mapper.paymentToePayment(jpa);});
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<Boolean> delete(final Long id) {
        return repository.delete(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<EPayment> getById(final Long id) {
        return repository.getById(id)
                .onItem()
                    .ifNotNull()
                        .transform(jpa -> {return Mapper.paymentToePayment(jpa);});
    }

    /**
     *
     * @return
     */
    @Override
    public Uni<List<EPayment>> getAll() {
        return repository.getAll()
                .onItem()
                    .ifNotNull()
                        .transform(jpa -> { return Mapper.paymentToePayment(jpa);});
    }

    /**
     *
     */
    static class Mapper {

        /**
         *
         * @param ePayment
         * @return
         */
        public static Payment ePaymentToPayment(final EPayment ePayment){
            Objects.nonNull(ePayment);

            var p = new Payment();

            p.setTotalCost(ePayment.getTotalCost());
            p.setCreatedAt(ePayment.getCreatedAt());
            p.setUpdatedAt(ePayment.getUpdatedAt());
            p.setCustomer(ePayment.getCustomer());
            p.setProductItem(ePayment.getProductItem());

            return p;
        }

        /**
         *
         * @param payment
         * @return
         */
        public static EPayment paymentToePayment(final Payment payment){
            Objects.nonNull(payment);

            var e = new EPayment();

            e.setTotalCost(payment.getTotalCost());
            e.setCreatedAt(payment.getCreatedAt());
            e.setUpdatedAt(payment.getUpdatedAt());
            e.setCustomer(payment.getCustomer());
            e.setProductItem(payment.getProductItem());

            return e;
        }

        /**
         *
         * @param payments
         * @return
         */
        public static List<EPayment> paymentToePayment(final List<Payment> payments){
            Objects.nonNull(payments);

            return payments.stream()
                    .map(jpa -> paymentToePayment(jpa))
                    .collect(Collectors.toList());
        }

    }
}
