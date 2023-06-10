import request from '@/utils/request'

// 查询兑换券管理列表
export function listMyTicket(query) {
  return request({
    url: '/rubbish/MyTicket/list',
    method: 'get',
    params: query
  })
}

// 查询兑换券管理详细
export function getMyTicket(id) {
  return request({
    url: '/rubbish/MyTicket/' + id,
    method: 'get'
  })
}

// 新增兑换券管理
export function addMyTicket(data) {
  return request({
    url: '/rubbish/MyTicket',
    method: 'post',
    data: data
  })
}

// 修改兑换券管理
export function updateMyTicket(data) {
  return request({
    url: '/rubbish/MyTicket',
    method: 'put',
    data: data
  })
}

// 删除兑换券管理
export function delMyTicket(id) {
  return request({
    url: '/rubbish/MyTicket/' + id,
    method: 'delete'
  })
}
