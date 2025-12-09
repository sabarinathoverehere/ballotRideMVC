<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="general-table">
    <table >
        <tr>
            <th>Payment ID</th>
            <th>Tender ID</th>
            <th>Owner ID</th>
            <th>Amount</th>
            <th>Status</th>
            <th>ACTION</th>
        </tr>

        <c:forEach var="p" items="${payments}">
            <tr>
                <td>${p.paymentId}</td>
                <td>${p.tenderId}</td>
                <td>${p.ownerId}</td>
                <td>${p.amount}</td>

                <td>
                    <c:choose>
                        <c:when test="${p.status == 'paid' || p.status == 'Paid'}">
                            <span style="color: green; font-weight: bold;">Paid</span>
                        </c:when>
                        <c:otherwise>
                            <span style="color: red; font-weight: bold;">Pending</span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <c:choose>

                        <c:when test="${p.status == 'Paid'}">
                            <button disabled>PAID</button>
                        </c:when>

                      
                        <c:otherwise>
                            <a
                                href="${pageContext.request.contextPath}/adminPay?id=${p.paymentId}">
                                <button class="approve-btn">PAY</button>
                            </a>
                        </c:otherwise>

                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>