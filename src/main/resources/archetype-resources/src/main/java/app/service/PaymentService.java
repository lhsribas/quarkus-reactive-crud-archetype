/**
 * @author Luiz Henrique de Sousa Ribas - lhs.ribas@gmail.com
 * @linkedin https://www.linkedin.com/in/lhsribas/
 * @date 24 Mar 2022
 * @version 1
 */
package ${package}.app.service;

import ${package}.app.dto.PaymentRequest;
import ${package}.app.dto.PaymentResponse;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface PaymentService {

    /**
     *
     * @param request
     * @return
     */
    Uni<PaymentResponse> save(final PaymentRequest request);

    /**
     *
     * @param id
     * @param request
     * @return
     */
    Uni<PaymentResponse> update(final Long id, PaymentRequest request);

    /**
     *
     * @param id
     * @return
     */
    Uni<Boolean> delete(final Long id);

    /**
     *
     * @param id
     * @return
     */
    Uni<PaymentResponse> getById(final Long id);

    /**
     *
     * @return
     */
    Uni<List<PaymentResponse>> getAll();
}
