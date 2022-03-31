/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.infra.db.repository;

import ${package}.infra.db.model.Payment;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface IPaymentRepository extends PanacheRepository<Payment> {

    /**
     *
     * @param id
     * @param payment
     * @return
     */
    Uni<Payment> update(final Long id, final Payment payment);

    /**
     *
     * @param payment
     * @return
     */
    Uni<Payment> save(final Payment payment);

    /**
     *
     * @return
     */
    Uni<List<Payment>> getAll();

    /**
     *
     * @param id
     * @return
     */
    Uni<Payment> getById(final Long id);

    /**
     *
     * @param id
     * @return
     */
    Uni<Boolean> delete(final Long id);

 }
