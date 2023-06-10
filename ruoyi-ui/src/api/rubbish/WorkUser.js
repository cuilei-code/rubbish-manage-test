import request from '@/utils/request'

// 查询工作端用户信息列表
export function listWorkUser(query) {
  return request({
    url: '/rubbish/WorkUser/list',
    method: 'get',
    params: query
  })
}

// 查询工作端用户信息详细
export function getWorkUser(id) {
  return request({
    url: '/rubbish/WorkUser/' + id,
    method: 'get'
  })
}

// 新增工作端用户信息
export function addWorkUser(data) {
  return request({
    url: '/rubbish/WorkUser',
    method: 'post',
    data: data
  })
}

// 修改工作端用户信息
export function updateWorkUser(data) {
  return request({
    url: '/rubbish/WorkUser',
    method: 'put',
    data: data
  })
}

// 删除工作端用户信息
export function delWorkUser(id) {
  return request({
    url: '/rubbish/WorkUser/' + id,
    method: 'delete'
  })
}
