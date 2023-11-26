package com.omidmohebbise.sp.modulith.order.service.dto;

import java.util.List;

public record OrderDTO(String customerFullName, String description, List<OrderItemDTO> orderItems) {
}

