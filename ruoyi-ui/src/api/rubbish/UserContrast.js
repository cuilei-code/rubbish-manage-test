import request from '@/utils/request'

// 查询新人拉新记录列表
export function listUserContrast(query) {
  return request({
    url: '/rubbish/UserContrast/list',
    method: 'get',
    params: query
  })
}

// 查询新人拉新记录详细
export function getUserContrast(id) {
  return request({
    url: '/rubbish/UserContrast/' + id,
    method: 'get'
  })
}

// 新增新人拉新记录
export function addUserContrast(data) {
  return request({
    url: '/rubbish/UserContrast',
    method: 'post',
    data: data
  })
}

// 修改新人拉新记录
export function updateUserContrast(data) {
  return request({
    url: '/rubbish/UserContrast',
    method: 'put',
    data: data
  })
}

// 删除新人拉新记录
export function delUserContrast(id) {
  return request({
    url: '/rubbish/UserContrast/' + id,
    method: 'delete'
  })
}
