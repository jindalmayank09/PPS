
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

	<nav aria-label="Page navigation example" style="text-align: right;">
	       <ul class="pagination justify-content-end">
	                  
              <c:choose>
              <c:when test="${page !=1}">
                  <li class="page-item">
                    <a class="page-link" onclick="submitPageForPagination(1)" tabindex="-1">First</a>
                  </li>
              </c:when>
              <c:otherwise>
                   <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">First</a>
                  </li>
              </c:otherwise>
              </c:choose>
              
              <c:choose>
              <c:when test="${page > 1}">
                   <li class="page-item">
                    <a class="page-link" onclick="submitPageForPagination(${page-1})" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                      <span class="sr-only">Previous</span>
                    </a>
                  </li>
              </c:when>
              <c:otherwise>
                   <li class="page-item disabled">
                        <a class="page-link" href="#" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                      <span class="sr-only">Previous</span>
                    </a>
                  </li>
              </c:otherwise>
              </c:choose>
             
              <c:set var="beginIndex" value="1" ></c:set>
              <c:set var="endIndex" value="${maxPages}" ></c:set>
            
              <c:choose>
                  <c:when test="${page == maxPages}">
                       <c:choose>
                          <c:when test="${maxPages-2 < 1 }">
                              <c:set var="beginIndex" value="1" ></c:set>
                          </c:when>
                          <c:otherwise>
                              <c:set var="beginIndex" value="${maxPages-2}" ></c:set>
                          </c:otherwise>
                      </c:choose>    
                      
                      <c:set var="endIndex" value="${maxPages}" ></c:set>
                  </c:when>
                  
                  <c:when test="${page+2 >= maxPages}">
                      <c:choose>
                          <c:when test="${page+2 > maxPages }">
                              <c:set var="beginIndex" value="${maxPages-2}" ></c:set>
                          </c:when>
                          <c:otherwise>
                              <c:set var="beginIndex" value="${page}" ></c:set>
                          </c:otherwise>
                      </c:choose>    
                      
                      <c:set var="endIndex" value="${maxPages}" ></c:set>
                  </c:when>
                  
                  <c:when test="${page+2 <= maxPages}">
                      <c:set var="beginIndex" value="${page}" ></c:set>
                      <c:set var="endIndex" value="${page+2}" ></c:set>
                  </c:when>
                  
              </c:choose>
              <c:if test="${beginIndex<1}">
                      <c:set var="beginIndex" value="1" ></c:set>
              </c:if>    
               <c:if test="${endIndex>maxPages}">
                      <c:set var="endIndex" value="maxPages" ></c:set>
              </c:if>    
              
              
            <%--     page=${page} || page+2 = ${page+2} || maxPages=${maxPages}
               beginIndex=${beginIndex}  || endIndex=${endIndex}  
             --%>    
              <c:forEach begin="${beginIndex}" end="${endIndex}" step="1" varStatus="i">
                  <c:choose>
                      <c:when test="${page == i.index}">
                          <li class="page-item disabled"><a class="page-link" href="#">${i.index}</a></li>
                          <span></span>
                      </c:when>
                      <c:otherwise>
                          <li class="page-item "><a class="page-link" onclick="submitPageForPagination(${i.index})">${i.index}</a></li>
                      </c:otherwise>
                  </c:choose>
              </c:forEach>
                  
              
               
              <c:choose>
              <c:when test="${page + 1 <= maxPages}">
                  <li class="page-item ">
                    <a class="page-link" onclick="submitPageForPagination(${page + 1})" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <span class="sr-only">Next</span>
                    </a>
                  </li>
              </c:when>
              <c:otherwise>
                  <li class="page-item disabled">
                    <a class="page-link" href="#" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <span class="sr-only">Next</span>
                    </a>
                  </li>
              </c:otherwise>
              </c:choose>
              
              <c:choose>
              <c:when test="${page == maxPages}">
                  <li class="page-item disabled">
                        <a class="page-link" href="#">Last</a>
                  </li>
              </c:when>
              <c:otherwise>
                  <li class="page-item">
                    <a class="page-link" onclick="submitPageForPagination(${maxPages})">Last</a>
                  </li>
              </c:otherwise>
               </c:choose>
               <li class="page-item">
                   <span class="page-link">Total Records ${totalResult}</span>    
                 
                </li>
                
            </ul>
          </nav>