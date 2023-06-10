import request from '@/utils/request'

// 查询临时积分列表
export function listTemporary(query) {
  return request({
    url: '/rubbish/temporary/list',
    method: 'get',
    params: query
  })
}

// 查询临时积分详细
export function getTemporary(id) {
  return request({
    url: '/rubbish/temporary/' + id,
    method: 'get'
  })
}

// 新增临时积分
export function addTemporary(data) {
  return request({
    url: '/rubbish/temporary',
    method: 'post',
    data: data
  })
}

// 修改临时积分
export function updateTemporary(data) {
  return request({
    url: '/rubbish/temporary',
    method: 'put',
    data: data
  })
}

// 删除临时积分
export function delTemporary(id) {
  return request({
    url: '/rubbish/temporary/' + id,
    method: 'delete'
  })
}
