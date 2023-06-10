import request from '@/utils/request'

// 查询客户端普通用户列表
export function listWxUser(query) {
  return request({
    url: '/rubbish/WxUser/list',
    method: 'get',
    params: query
  })
}

// 查询客户端普通用户详细
export function getWxUser(id) {
  return request({
    url: '/rubbish/WxUser/' + id,
    method: 'get'
  })
}

// 新增客户端普通用户
export function addWxUser(data) {
  return request({
    url: '/rubbish/WxUser',
    method: 'post',
    data: data
  })
}

// 修改客户端普通用户
export function updateWxUser(data) {
  return request({
    url: '/rubbish/WxUser',
    method: 'put',
    data: data
  })
}

// 删除客户端普通用户
export function delWxUser(id) {
  return request({
    url: '/rubbish/WxUser/' + id,
    method: 'delete'
  })
}
