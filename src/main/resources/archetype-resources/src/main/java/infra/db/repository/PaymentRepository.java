/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.infra.db.repository;

import ${package}.infra.db.model.Payment;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.List;

@ApplicationScoped
final class PaymentRepository implements IPaymentRepository {

    /**
     *
     * @param id
     * @param payment
     * @return
     */
    @Override
    public Uni<Payment> update(final Long id, final Payment payment) {
        return Panache
                .withTransaction(() -> getById(id)
                        .onItem().ifNotNull()
                        .transform(entity -> {
                            entity.setTotalCost(payment.getTotalCost());
                            return entity;
                        })
                        .onFailure().recoverWithNull());
    }

    /**
     *
     * @param payment
     * @return
     */
    @Override
    public Uni<Payment> save(final Payment payment) {
        return Panache
                .withTransaction(payment::persist)
                    .replaceWith(payment)
                    .ifNoItem()
                        .after(Duration.ofMillis(10000))
                            .fail()
                        .onFailure()
                .transform(t -> new IllegalStateException(t));
    }

    /**
     *
     * @return
     */
    @Override
    public Uni<List<Payment>> getAll() {
        return listAll(Sort.by("createdAt"))
                .ifNoItem()
                    .after(Duration.ofMillis(10000))
                        .fail()
                    .onFailure()
                .transform(t -> new IllegalStateException());
                //.recoverWithUni(Uni.createFrom().<List<PanacheEntityBase>>item(Collections.EMPTY_LIST));
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<Payment> getById(final Long id) {
        return findById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Uni<Boolean> delete(final Long id) {
        return Panache.withTransaction(() -> deleteById(id));
    }
}
